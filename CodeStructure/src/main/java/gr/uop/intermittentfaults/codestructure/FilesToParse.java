/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.codestructure;

import java.util.ArrayList;

/**
 *
 * @author Panos
 */
public class FilesToParse {

    private ArrayList<FileStructure> files;

    public FilesToParse() {
        this.files = new ArrayList<>();
    }

    public FilesToParse(ArrayList<FileStructure> files) {
        this.files = files;
    }

    public ArrayList<FileStructure> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FileStructure> files) {
        this.files = files;
    }

    public void addFileStructure(FileStructure fStructure) {
        this.files.add(fStructure);
        fStructure.setParent(this);
    }

    public void removeFileStructure(FileStructure fStructure) {
        this.files.remove(fStructure);
    }

    public void printFilesToParse() {
        System.out.println("----- FILES TO PARSE ----- ");
        System.out.println("FILESTRUCTURES : ");
        for (FileStructure myFile : files) {
            myFile.printFileStructure();
        }
    }
}
