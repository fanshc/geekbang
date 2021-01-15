package java_.training.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class CustomClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Object obj = customClassLoader.findClass("Hello").newInstance();
        obj.getClass().getMethod("hello").invoke(obj);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte [] classBytes = this.getClassByteFromFile("/java_/training/classloader/Hello.xlass");
        return defineClass(name,classBytes,0, classBytes.length);
    }

    private byte[] getClassByteFromFile(String filePath){
        InputStream in = null;
        try{
            try{
                in = this.getClass().getResourceAsStream(filePath);
                return toByteArray(in);
            }finally {
                if (in != null) {
                    in.close();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            buffer = convertByteArray(buffer);
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
    private byte[] convertByteArray(byte [] buffer){
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) ~buffer[i];
        }
        return buffer;
    }

}
