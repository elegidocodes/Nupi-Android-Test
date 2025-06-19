package com.elegidocodes.androidtest.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Fernando Ismael Canul Caballero
 * @version 1.0.0
 */
public class FileUtils {

    /**
     * Converts an image {@link Uri} to a {@link File} in a specified directory.
     *
     * <p>This method decodes an image from the provided {@link Uri}, compresses it using the specified
     * {@link Bitmap.CompressFormat}, and saves it to a file in the specified directory. The file's extension
     * is determined by the MIME type, ensuring proper file association. The compression quality is customizable,
     * allowing the user to control the output file size and image quality.</p>
     *
     * <p>Example usage:
     * <pre>{@code
     * Uri imageUri = ...; // A valid image Uri
     * String directory = context.getCacheDir().getAbsolutePath();
     * File imageFile = FileUtil.uriToFileForImage(context, imageUri, directory, "image/jpeg", 80);
     * if (imageFile != null) {
     *     System.out.println("Image file created at: " + imageFile.getAbsolutePath());
     * }
     * }</pre>
     *
     * @param context         The application context for accessing content resolver.
     * @param uri             The {@link Uri} of the image to convert.
     * @param directory       The directory where the image file will be saved.
     * @param mimeType        The MIME type of the image (e.g., "image/jpeg" or "image/png").
     * @param compressQuality The compression quality for the image (0–100, where 100 is the highest quality).
     * @return A {@link File} object pointing to the saved image file, or {@code null} if an error occurred.
     */
    public static File uriToFileForImage(Context context, Uri uri, String directory, String mimeType, int compressQuality) {
        Bitmap.CompressFormat compressFormat;
        String fileExtension;

        try (InputStream inputStream = context.getContentResolver().openInputStream(uri)) {
            if (inputStream == null) {
                Log.e("FileUtil", "Failed to open InputStream for URI: " + uri);
                return null;
            }

            // Decode the image from the InputStream
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            if (bitmap == null) {
                Log.e("FileUtil", "Failed to decode image from URI: " + uri);
                return null;
            }

            // Determine the compress format and file extension based on MIME type
            if ("image/png".equalsIgnoreCase(mimeType)) {
                compressFormat = Bitmap.CompressFormat.PNG;
                fileExtension = ".png";
            } else if ("image/jpeg".equalsIgnoreCase(mimeType) || "image/jpg".equalsIgnoreCase(mimeType)) {
                compressFormat = Bitmap.CompressFormat.JPEG;
                fileExtension = ".jpg";
            } else {
                Log.e("FileUtil", "Unsupported MIME type: " + mimeType);
                return null;
            }

            // Create the output file with the appropriate extension
            File outputFile = createFile("image", fileExtension, directory, "yyyyMMdd_HHmmss");
            if (outputFile == null) {
                Log.e("FileUtil", "Failed to create output file");
                return null;
            }

            // Write the compressed bitmap to the file
            try (OutputStream outputStream = new FileOutputStream(outputFile)) {
                if (!bitmap.compress(compressFormat, compressQuality, outputStream)) {
                    Log.e("FileUtil", "Failed to compress and save the image");
                    return null;
                }
            }

            return outputFile;

        } catch (Exception e) {
            Log.e("FileUtil", "Error converting URI to file: " + uri, e);
            return null;
        }
    }

    /**
     * Creates a temporary file with a specified prefix, suffix, directory, and date pattern.
     *
     * <p>This method generates a file in the specified directory. If the directory does not exist,
     * it will attempt to create it. The prefix and suffix can be customized, and a date pattern can be
     * used to include timestamps in the file name.</p>
     *
     * <p>Example usage:
     * <pre>{@code
     * String directory = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
     * File file = FileUtil.createFile("file", ".txt", directory, "yyyy-MM-dd_HH-mm-ss");
     * System.out.println("File created at: " + file.getAbsolutePath());
     * }</pre>
     *
     * @param prefix      The prefix for the file name. If null or empty, the default date pattern will be used.
     * @param suffix      The suffix for the file name (e.g., ".txt"). If null or empty, no suffix is added.
     * @param directory   The directory where the file will be created.
     * @param datePattern The date pattern to include in the file name. If null or empty, the default pattern "yyyyMMdd_HHmmss" is used.
     * @return A {@link File} object pointing to the created file.
     * @throws IOException If an error occurs during file creation.
     */
    public static File createFile(String prefix, String suffix, String directory, String datePattern) throws IOException {
        // Use default date pattern if none is provided
        if (datePattern == null || datePattern.isEmpty()) {
            datePattern = "yyyyMMdd_HHmmss";
        }

        // Generate the timestamp for the file name
        String timestamp = new SimpleDateFormat(datePattern, Locale.getDefault()).format(new Date());

        // Use the timestamp as prefix if no prefix is provided
        if (prefix == null || prefix.isEmpty()) {
            prefix = timestamp;
        } else {
            prefix = prefix + "_" + timestamp;
        }

        // Use empty suffix if none is provided
        if (suffix == null || suffix.isEmpty()) {
            suffix = "";
        }

        // Ensure the storage directory exists
        File fileDirectory = new File(directory);
        if (!fileDirectory.exists()) {
            boolean mkdirsResult = fileDirectory.mkdirs();
            if (mkdirsResult) {
                Log.d("FileUtil", "Directory created: " + fileDirectory.getAbsolutePath());
            } else {
                Log.e("FileUtil", "Failed to create directory: " + fileDirectory.getAbsolutePath());
            }
        }

        // Create the temporary file in the specified directory

        return File.createTempFile(prefix, suffix, fileDirectory);
    }

}
