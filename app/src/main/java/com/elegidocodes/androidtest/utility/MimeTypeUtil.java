package com.elegidocodes.androidtest.utility;

import android.content.Context;
import android.net.Uri;

/**
 * @author Fernando Ismael Canul Caballero
 * @version 1.0.0
 */
public class MimeTypeUtil {

    /**
     * Retrieves the MIME type of a given URI.
     *
     * <p>This method attempts to determine the MIME type of a URI using the following steps:
     * <ul>
     *     <li>First, it queries the system's content resolver for the MIME type.</li>
     *     <li>If the MIME type cannot be determined directly, it falls back to using the file extension.</li>
     * </ul>
     *
     * <p>Example usage:
     * <pre>{@code
     * Uri fileUri = Uri.parse("content://path/to/file.jpg");
     * String mimeType = getMimeType(context, fileUri);
     * System.out.println("MIME Type: " + mimeType); // Output: image/jpeg
     * }</pre>
     *
     * @param context The context to access the content resolver.
     * @param uri     The URI of the file for which to retrieve the MIME type.
     * @return The MIME type of the file as a string, or {@code null} if it could not be determined.
     */
    public static String getMimeType(Context context, Uri uri) {
        String mimeType = context.getContentResolver().getType(uri);
        if (mimeType == null && uri.getPath() != null) {
            // Try to determine MIME type based on the file extension
            String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(uri.getPath());
            if (extension != null) {
                mimeType = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
            }
        }
        return mimeType;
    }

}