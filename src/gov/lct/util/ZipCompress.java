package gov.lct.util;

import java.io.BufferedInputStream;  
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;  
import java.util.zip.CheckedOutputStream;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipOutputStream;  

public class ZipCompress {
static final int BUFFER = 8192;     
    
    private File zipFile;     
      
    public ZipCompress (String pathName) {     
        zipFile = new File(pathName);     
    }     
    public void compress(String... pathName) {   
        ZipOutputStream out = null;     
        try {    
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);     
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,     
                    new CRC32());     
            out = new ZipOutputStream(cos);     
            String basedir = "";   
            for (int i=0;i<pathName.length;i++){  
                compress(new File(pathName[i]), out, basedir);     
            }  
            out.close();    
        } catch (Exception e) {     
            throw new RuntimeException(e);     
        }   
    }     
    public void compress(String srcPathName) {     
        File file = new File(srcPathName);     
        if (!file.exists())     
            throw new RuntimeException(srcPathName + "不存在！");     
        try {     
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);     
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,     
                    new CRC32());     
            ZipOutputStream out = new ZipOutputStream(cos);     
            String basedir = "";     
            compress(file, out, basedir);     
            out.close();     
        } catch (Exception e) {     
            throw new RuntimeException(e);     
        }     
    }     
    
    private void compress(File file, ZipOutputStream out, String basedir) {     
        /* 判断是目录还是文件 */    
        if (file.isDirectory()) {     
            System.out.println("压缩：" + basedir + file.getName());     
            this.compressDirectory(file, out, basedir);     
        } else {     
            System.out.println("压缩：" + basedir + file.getName());     
            this.compressFile(file, out, basedir);     
        }     
    }     
    
    /** 压缩一个目录 */    
    private void compressDirectory(File dir, ZipOutputStream out, String basedir) {     
        if (!dir.exists())     
            return;     
    
        File[] files = dir.listFiles();     
        for (int i = 0; i < files.length; i++) {     
            /* 递归 */    
            compress(files[i], out, basedir + dir.getName() + "/");     
        }     
    }     
    
    /** 压缩一个文件 */    
    private void compressFile(File file, ZipOutputStream out, String basedir) {     
        if (!file.exists()) {     
            return;     
        }     
        try {     
            BufferedInputStream bis = new BufferedInputStream(     
                    new FileInputStream(file));     
            ZipEntry entry = new ZipEntry(basedir + file.getName());     
            out.putNextEntry(entry);     
            int count;     
            byte data[] = new byte[BUFFER];     
            while ((count = bis.read(data, 0, BUFFER)) != -1) {     
                out.write(data, 0, count);     
            }     
            bis.close();     
        } catch (Exception e) {     
            throw new RuntimeException(e);     
        }     
    } 
    
    
    public void compress(String src, String des) throws IOException{
    	// 要被压缩的文件夹
        String fileName1 = "D:" + File.separator + "javaIo" + File.separator + "hello";
        fileName1 = src;
        File file = new File(fileName1);
        String zipFileName = "d:" + File.separator + "javaIo" + File.separator + file.getName()+".zip";
        zipFileName = des;
        File zipFile = new File(zipFileName);
        
        InputStream input = null;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        // zip的名称为
        zipOut.setComment(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; ++i) {
                input = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
                int temp = 0;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
                input.close();
            }
        }
        zipOut.close();
    }
}
