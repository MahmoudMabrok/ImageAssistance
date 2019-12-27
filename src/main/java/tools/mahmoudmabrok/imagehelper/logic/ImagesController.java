/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.mahmoudmabrok.imagehelper.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author mo3tamed
 */
public final class ImagesController {

    private static final String sucess = "FInished Successully";
    private static final String fail = "Failed";

    public static String fitGooglePlay(String path) {

        //String path = "/home/mo3tamed/Videos/images/";
        String src;
        String dst;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            // get list of file names, then use it with path above
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(item -> item.getFileName().toString()
                    ).collect(Collectors.toList());

            for (String img : result) {
                src = path + img;
                dst = path + "modified_" + img;
                ImageResiszer.resize(src, dst);
            }

            return sucess;

        } catch (IOException e) {
            return fail;
        }
    }

    public static String renameAll(String path, String prefix) {
        //String path = "/home/mo3tamed/Videos/images/";

        String src;
        String dst;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            // get list of file names, then use it with path above
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(item -> item.getFileName().toString()
                    ).collect(Collectors.toList());

            int total = result.size();
            if (!path.endsWith("/")) {
                path += "/";
            }
            for (String img : result) {
                src = path + img;
                dst = path + prefix + img;
                CreateNewFile(src, dst);
            }

            return sucess;

        } catch (IOException e) {
            return fail;
        }
    }

    private static void CreateNewFile(String src, String dst) {
        try {
            File f1 = new File(src);
            File f2 = new File(dst);
            Files.copy(f1.toPath(), f2.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ImagesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String resize(String path, int w, int h) {
        String src;
        String dst;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            // get list of file names, then use it with path above
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(item -> item.getFileName().toString()
                    ).collect(Collectors.toList());

            for (String img : result) {
                src = path + img;
                dst = path + "modified_" + img;
                ImageResiszer.resize(src, dst,w,h);
            }

            return sucess;

        } catch (IOException e) {
            return fail;
        }
    }
    
    
    

}
