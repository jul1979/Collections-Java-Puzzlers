package be.smals.paumard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class C_PlayWithRecordAndIO {

    record RangeRecord(int begin, int end) implements Serializable {
        RangeRecord {
            if (begin > end) {
                throw new IllegalStateException("End should be greater than begin");
            }
        }
    }

    static class RangeClass implements Serializable {
        private final int begin;
        private final int end;

        RangeClass(int begin, int end) {
//            if (begin > end) {
//                throw new IllegalStateException("End should be greater than begin");
//            }
            this.begin = begin;
            this.end = end;
            System.out.println("Running Range class constructor");
        }

        @Override
        public String toString() {
            return "Range{" +
                    "begin=" + begin +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*        var range = new RangeRecord(10, 0);
        System.out.println("range = " + range);

        var fos = Files.newOutputStream(Path.of("files/range-10-0.dat"));
        var oos = new ObjectOutputStream(fos);

        oos.writeObject(range);*/

      /*var is = Files.newInputStream(Path.of("files/range-10-0.dat"));
      var ois = new ObjectInputStream(is);
      System.out.println("Reading range");
      var readRange = ois.readObject();
      System.out.println("readRange = " + readRange);*/
    }
}
