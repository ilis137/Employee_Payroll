package com.javapractice;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";
    Path playPath = Paths.get(HOME + "/"+PLAY_WITH_NIO);
    Path homePath = Paths.get(HOME);
    
     //Check File Exists
    @Test
    public void checkFileExists() throws IOException {
        Assert.assertTrue(Files.exists(homePath));
    }
    
     //Delete File And Check File Not Exist
    @Test
    public void checkFileNotExists(){
         if (Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
         Assert.assertTrue(Files.notExists(playPath));
 
    }    
     //Create Directory
    @Test
    public void checkCreateDirectory() throws IOException{
    
     Files.createDirectories(playPath);
     Assert.assertTrue(Files.exists(playPath));

    }
     //Create File
    @Test
    public void checkCreateFile(){
          IntStream.range(1,10).forEach(fileNumber ->{
            Path tempFile = Paths.get(playPath + "/temp"+fileNumber);
            Assert.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            }catch (IOException e){}
            Assert.assertTrue(Files.exists(tempFile));
        } );

    }

    //List Files, Directories as well as Files with Extension
    @Test
    public void checkListFiles() throws IOException{
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath , path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);
    }


    //watch files
    @Test
    public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchService(dir).processEvents();
        Path newFile=Paths.get(HOME+"/"+PLAY_WITH_NIO+"/test");
        Assert.assertTrue(Files.exists(newFile));
    }
}