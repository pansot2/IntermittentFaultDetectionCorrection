/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.appendfilelines;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Panos
 */
public class AddImport {
    public static void addLines(File file, String importName) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int i=0;
        for (String line : lines) {
            if (line.contains("package")){
                lines.set(i, lines.get(i) + " " + importName);
                break;
            }
            i++;
        }
        Files.write(file.toPath(), lines);
    }
}
