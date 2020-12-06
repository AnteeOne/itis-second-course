import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class StudentChannel {

    private Path filePath;

    public StudentChannel(Path filePath) {
        this.filePath = filePath;
    }

    public Student readStudent(){

        Student student = new Student();

        try {
            RandomAccessFile store = new RandomAccessFile(filePath.toString(), "rw");
            FileChannel channel = store.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(129);
            int numOfBytesRead = channel.read(buffer);
            System.out.println("Number of bytes has red : " + numOfBytesRead);
            buffer.flip();

            // parsing bytes from buffer
            student.setHungry(buffer.get() == 1);
            student.setMoney(buffer.getInt());
            student.setGroup(buffer.getInt());

            byte[] nameBytes = new byte[buffer.remaining()];
            buffer.get(nameBytes);

            String studentName = new String(nameBytes,StandardCharsets.UTF_8);
            student.setName(studentName);

            channel.close();
            store.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void writeStudent(Student student){
        try {
            RandomAccessFile store = new RandomAccessFile(filePath.toString(), "rw");
            FileChannel channel = store.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(129);
            buffer.put((byte) (student.isHungry ? 1:0));
            buffer.putInt(student.money);
            buffer.putInt(student.group);
            buffer.put(student.name.getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            channel.write(buffer);
            channel.close();
            store.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
