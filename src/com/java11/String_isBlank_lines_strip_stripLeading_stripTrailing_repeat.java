package com.java11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class String_isBlank_lines_strip_stripLeading_stripTrailing_repeat {

	public static void main(String[] args) {
		Path tempDir = Paths.get("C:/Users/rafid/eclipse-workspace/Practice/src/com/java11");

		Path filesPath;
		Path filePath;
		try {
			filePath = Files.writeString(Files.createTempFile(tempDir, "demo", ".txt"), "Sample text");
			String fileContent = Files.readString(filePath);
			System.out.println("fileLocation => " + Files.getFileStore(filePath) + ", fileName=> "
					+ filePath.getFileName() + ",content in the file => " + fileContent);
			
			//appending data to the existing file
			filesPath = Paths.get("C:/Users/rafid/eclipse-workspace/Practice/src/com/java11",
					filePath.getFileName().toString());
			Files.writeString(filesPath, " \n appended Hello World !!", StandardOpenOption.APPEND);

			// Optionally verify the file content
			String content = Files.readString(filesPath);
			System.out.println(content);
			
			//Rename the file
			File file = new File("C:/Users/rafid/eclipse-workspace/Practice/src/com/java11/"+filePath.getFileName().toString());
			System.out.println(file+", "+file.renameTo(new File("C:/Users/rafid/eclipse-workspace/Practice/src/com/java11/demo.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
