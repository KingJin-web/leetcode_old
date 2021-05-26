package com.king.other;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: PosixFilePermission的Java设置文件权限，
 * @author: King
 * @create: 2021-05-26 16:38
 */
public class FilePermissions {
    /**
     * File Permissions Java Example using File and PosixFilePermission
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/pankaj/temp.txt");
//
//        //set application user permissions to 455
//        file.setExecutable(false);
//        file.setReadable(false);
//        file.setWritable(true);
//
//        //change permission to 777 for all the users
//        //no option for group and others
//        file.setExecutable(true, false);
//        file.setReadable(true, false);
//        file.setWritable(true, false);

        //using PosixFilePermission to set file permissions 777
        Set<PosixFilePermission> perms = new HashSet<>();
        //add owners permission
        perms.add(PosixFilePermission.OWNER_READ);
//        perms.add(PosixFilePermission.OWNER_WRITE);
//        perms.add(PosixFilePermission.OWNER_EXECUTE);
//        //add group permissions
//        perms.add(PosixFilePermission.GROUP_READ);
//        perms.add(PosixFilePermission.GROUP_WRITE);
//        perms.add(PosixFilePermission.GROUP_EXECUTE);
//        //add others permissions
//        perms.add(PosixFilePermission.OTHERS_READ);
//        perms.add(PosixFilePermission.OTHERS_WRITE);
//        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        //file:///D:/MyJava/a.html
        Files.setPosixFilePermissions(Paths.get("a.txt"), perms);
    }


}
