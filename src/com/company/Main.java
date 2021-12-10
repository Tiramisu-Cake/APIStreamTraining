package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;


public class Main {

    public static void main(String[] args) {
        File root = new File(".");
        int max_depth = 10;
        Stream<File>[] streamarr = new Stream[max_depth];
        streamarr[0] = (Arrays.asList(root.listFiles())).stream();
        for(int depth = 0; depth < max_depth; depth++) {
            final int i = depth;
            if(streamarr[i] == null) {
                System.out.println("Достигнута максимальная глубина.");
                break;
            }
            System.out.println("Каталоги и файлы глубины " + i + ":");
            if(i<max_depth - 1) {
                streamarr[i].peek(System.out::println)
                        .filter(x -> x.isDirectory())
                        .forEach(x -> streamarr[i + 1] = (Arrays.asList(x.listFiles())).stream());
            } else {
                streamarr[i].forEach(System.out::println);
            }
        }

        //ArrayList<File> expandCopy = Stream.of(Arrays.asList(root.listFiles()))
         //       .collect(Collectors.toList());
        //Stream stream = expand.stream();
       // stream.filter(x -> x.isDirectory() == true)
        //        .collect();;
        /*
        for(int depth = 0; depth < 10; depth++) {
            File[] expandCopy = expand.toArray(new File[expand.size()]);
            expand.clear();
            for (File file : expandCopy) {
                System.out.println(depth + " " + file);
                if (file.isDirectory()) {
                    expand.addAll(Arrays.asList(file.listFiles()));
                }
            }
        }
        */
        /*
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::print);
        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(System.out::println);

         */
    }
}
