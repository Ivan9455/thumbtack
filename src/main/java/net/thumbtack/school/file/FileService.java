package net.thumbtack.school.file;


import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;


import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) {
        try (FileOutputStream fin = new FileOutputStream(file)) {
            for (byte arr : array) {
                fin.write(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static byte[] readByteArrayFromBinaryFile(String fileName) {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) {
        byte[] buffer = null;
        try (FileInputStream fin = new FileInputStream(file)) {
            buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());
            return buffer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        try (ByteArrayInputStream in = new ByteArrayInputStream(array); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            for (int i = 0; i < in.available(); i++) {
                if (i % 2 == 0) {
                    out.write(array[i]);
                }
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) {
        writeByteArrayToBinaryFile(fileName, array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) {
        writeByteArrayToBinaryFile(file, array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) {
        return readByteArrayFromBinaryFile(file);
    }


    public static void writeRectangleToBinaryFile(File file, Rectangle rect) {
        try (FileOutputStream fin = new FileOutputStream(file,true);
             DataOutputStream dataOutputStream = new DataOutputStream(fin)) {
            dataOutputStream.writeInt(rect.getTopLeft().getX());
            dataOutputStream.writeInt(rect.getTopLeft().getY());
            dataOutputStream.writeInt(rect.getBottomRight().getX());
            dataOutputStream.writeInt(rect.getBottomRight().getY());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) {
        try (FileInputStream ois = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(ois)) {
            return new Rectangle(
                    dataInputStream.readInt(),
                    dataInputStream.readInt(),
                    dataInputStream.readInt(),
                    dataInputStream.readInt(),
                    Color.RED);
        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) {
        for (Rectangle rec : rects) {
            writeRectangleToBinaryFile(file, rec);
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) {
        Rectangle[] rect = new Rectangle[(int) (file.length() / 16)];
        try (FileInputStream ois = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(ois)) {
            for (int i = (int) (file.length() / 16) - 1; i >= 0; i--) {
                rect[i] = new Rectangle(
                        dataInputStream.readInt(),
                        dataInputStream.readInt(),
                        dataInputStream.readInt(),
                        dataInputStream.readInt(),
                        Color.RED);
            }
        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }
        return rect;
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) {
        try (FileOutputStream fin = new FileOutputStream(file);
             DataOutputStream dataOutputStream = new DataOutputStream(fin)) {
            dataOutputStream.writeChars(rect.getTopLeft().getX() + " " + rect.getTopLeft().getY() + " " + rect.getBottomRight().getX() + " " + rect.getBottomRight().getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) {
        try (FileInputStream ois = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(ois))) {
            String[] re = reader.readLine().split(" ");
            return new Rectangle(
                    Integer.parseInt(re[0].replaceAll("\\W", "")),
                    Integer.parseInt(re[1].replaceAll("\\W", "")),
                    Integer.parseInt(re[2].replaceAll("\\W", "")),
                    Integer.parseInt(re[3].replaceAll("\\W", "")),
                    Color.RED);
        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) {
        try (FileOutputStream fin = new FileOutputStream(file);
             DataOutputStream dataOutputStream = new DataOutputStream(fin)) {
            dataOutputStream.writeChars(String.valueOf(rect.getTopLeft().getX()) + "\n");
            dataOutputStream.writeChars(String.valueOf(rect.getTopLeft().getY()) + "\n");
            dataOutputStream.writeChars(String.valueOf(rect.getBottomRight().getX()) + "\n");
            dataOutputStream.writeChars(String.valueOf(rect.getBottomRight().getY()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) {
        try (FileInputStream ois = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(ois))) {
            String[] re = new String[Files.readAllLines(file.toPath()).size()];
            for (int i = 0; i < re.length; i++) {
                re[i] = Arrays.toString(reader.readLine().split(" "));
            }
            return new Rectangle(
                    Integer.parseInt(re[0].replaceAll("\\W", "")),
                    Integer.parseInt(re[1].replaceAll("\\W", "")),
                    Integer.parseInt(re[2].replaceAll("\\W", "")),
                    Integer.parseInt(re[3].replaceAll("\\W", "")),
                    Color.RED);
        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) {
        try (FileOutputStream fin = new FileOutputStream(file);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fin))) {
            bw.write(trainee.getFirstName() + " ");
            bw.write(trainee.getLastName() + " ");
            bw.write(trainee.getRating() + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) {
        try (FileInputStream ois = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(ois))) {
            String[] re = reader.readLine().split(" ");
            return new Trainee(
                    re[0],
                    re[1],
                    Integer.parseInt(re[2])
            );
        } catch (IOException | TrainingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) {
        try (FileOutputStream fin = new FileOutputStream(file);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fin))) {
            bw.write(trainee.getFirstName());
            bw.newLine();
            bw.write(trainee.getLastName());
            bw.newLine();
            bw.write(trainee.getRating());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) {
        try (FileInputStream ois = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(ois))) {
            return new Trainee(
                    reader.readLine(),
                    reader.readLine(),
                    reader.read()
            );
        } catch (IOException | TrainingException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) {
        writeTraineeToTextFileThreeLines(file, trainee);
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) {
        return readTraineeFromTextFileThreeLines(file);
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        return new Gson().toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        return new Gson().fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) {
        try (FileOutputStream fin = new FileOutputStream(file);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fin))) {
            bw.write(serializeTraineeToJsonString(trainee));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) {
        try (FileInputStream ois = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(ois))) {
            return deserializeTraineeFromJsonString(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

