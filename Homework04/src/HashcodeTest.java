import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class HashcodeTest {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ArrayList<File> arrayList = new ArrayList<>();
        ArrayList<File> pathList = dfs("E:\\Learning Materials\\Peking\\FirstSemester\\JavaProgramming\\PPT",arrayList);
        for (File fi : pathList) {
            System.out.println(fi.getName()+'\n'+shaHashcode(fi));
        }
        Vector<InputStream> streams = new Vector<>();
        for (File fi:pathList) {
            InputStream input1 = new FileInputStream(fi);
            streams.add(input1);
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(streams.elements());
        System.out.println("-------------------------------------------------");
        System.out.println("Folder-->" + SHA1Sum(sequenceInputStream));
    }

    //递归遍历文件夹和文件
    public static ArrayList<File> dfs(String path,ArrayList<File> arrayList) {
        File dir = new File(path);
        File[] fs = dir.listFiles();
        for(File item:fs) {
            if(item.isFile()) {
                arrayList.add(item);
                Arrays.sort(fs, new Comparator<File>() { //对文件按照文件名进行排序
                    public int compare(File f1, File f2) {
                        return f1.getName().compareTo(f2.getName());
                    }
                });
//                System.out.println("file:"+item.getAbsolutePath());
            }
            if(item.isDirectory()) {
//                arrayList.add("dictionary "+fs[i].getAbsolutePath());
//                System.out.println("dictionary "+fs[i].getAbsolutePath());
                dfs(path+File.separator+item.getName(),arrayList);
            }
        }
        return arrayList;
    }

    //计算文件加的哈希值
    public static String SHA1Sum(SequenceInputStream seq) throws NoSuchAlgorithmException, IOException {
        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("SHA-1");
        int numRead = 0;
        do {
            numRead = seq.read(buffer);
            if(numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        }while(numRead != -1);

        seq.close();
        byte[] sha1Bytes = complete.digest();
        BigInteger bigInteger = new BigInteger(1,sha1Bytes);
        return bigInteger.toString(16);
    }

    // 计算文件的哈希值
    public static String Hashcompute(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        //创建文件缓冲区
        byte[] buffer = new byte[1024];
        // 使用SHA1哈希/摘要算法
        MessageDigest complete = MessageDigest.getInstance("SHA-1");
        int numRead = 0;
        do {
            numRead = inputStream.read(buffer);
            if(numRead>0) {
                complete.update(buffer,0,numRead);
            }
        }while (numRead!=-1);
        inputStream.close();
        byte[] sha1Bytes = complete.digest();
        BigInteger bigInteger = new BigInteger(1,sha1Bytes);
        return bigInteger.toString(16);
    }

    public static String shaHashcode(File file) throws IOException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream(file);
        return Hashcompute(fis);
    }
}
