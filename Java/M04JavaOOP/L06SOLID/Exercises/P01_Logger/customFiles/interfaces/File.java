package P01_Logger.customFiles.interfaces;

public interface File {
    void write();
    int getSize();
    void appendBuffer(String text);
}
