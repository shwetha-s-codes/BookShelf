import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@MultipartConfig // Annotation for Informing file uploads
@WebServlet("/bookinfoServlet")
public class bookinfoServlet extends HttpServlet {
    private static final String uploadDir = "D:/ImageUploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookname = request.getParameter("bookname"); 
        PrintWriter out=response.getWriter();
        out.println(bookname);
        
        // Accessing Bookname

        // Code to store the images in the Images folder
        Part filePart = request.getPart("coverimage");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        System.out.println("Extracted file name: " + fileName);

        // Sanitize the file name
        fileName = fileName.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
        System.out.println("Sanitized file name: " + fileName);

        // Verify directory
        Path folderPath = Paths.get(uploadDir);
        boolean isWritable = Files.isWritable(folderPath);
        System.out.println("Writable: " + isWritable);
        System.out.println("Temporary directory: " + System.getProperty("java.io.tmpdir"));

        // Save File to the server
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = filePart.getInputStream();
            File outputFile = new File(uploadDir + File.separator + fileName);
            outputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File uploaded successfully to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().write("Error while uploading file: " + e.getMessage());
        } finally {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        }

        String author = request.getParameter("author"); // Accessing Author name
        String rating = request.getParameter("rating"); // Accessing Rating
    }
}