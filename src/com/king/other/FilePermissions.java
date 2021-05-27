package com.king.other;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: PosixFilePermission的Java设置文件权限，
 * @author: King
 * @create: 2021-05-26 16:38
 */
public class FilePermissions {

//    public static void ToFile777(String file){
//        Set<PosixFilePermission> perms = new HashSet<>();
//
//        perms.add(PosixFilePermission.OWNER_READ);
//        perms.add(PosixFilePermission.OWNER_WRITE);
//        perms.add(PosixFilePermission.OWNER_EXECUTE);
//
//        perms.add(PosixFilePermission.GROUP_READ);
//        perms.add(PosixFilePermission.GROUP_WRITE);
//        perms.add(PosixFilePermission.GROUP_EXECUTE);
//
//        perms.add(PosixFilePermission.OTHERS_READ);
//        perms.add(PosixFilePermission.OTHERS_WRITE);
//        perms.add(PosixFilePermission.OTHERS_EXECUTE);
//
//        try {
//            Files.setPosixFilePermissions(Paths.get("test/java.txt"), perms);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * File Permissions Java Example using File and PosixFilePermission
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        for (PosixFilePermission c : PosixFilePermission.values())
            System.out.println(c);
//        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
//        Files.setPosixFilePermissions(Paths.get("test/test.txt"), perms);
    }


}
