package davis.graal;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.graalvm.nativeimage.c.CContext;


public class Directives implements CContext.Directives {
    private static Path buildDir = null;

    static{
        String includeDirs = null;
        try{
            includeDirs = System.getenv("NATIVE_INCLUDE_DIR");
            System.out.println("WE GOT IT");
        }catch(Exception e){
            //Do Nothing
        }

        if(includeDirs == null || includeDirs.trim().equalsIgnoreCase("")){
            includeDirs = ".";
        }

        buildDir = Paths.get(includeDirs);
    }



    @Override
    public List<String> getOptions() {
        //This si GCC or Clang compiler options

        String[] libs = new String[]{
                "-Icc_src"
        };

        return Arrays.asList(libs);
    }

    @Override
    public List<String> getHeaderFiles() {
        //Header file needed to reference
        String[] headers = new String[]{
                "<stdio.h>",
                "<stdlib.h>",
                "<string.h>",
                "<libavformat/avformat.h>"
                ,
                "<libavformat/avio.h>"
                ,
                "<libavcodec/avcodec.h>"
                ,
                "<libavutil/avutil.h>"
                ,
                "<libavfilter/avfilter.h>"
                ,
                "<libavfilter/buffersink.h>"
                ,
                "<libavfilter/buffersrc.h>"
                ,
                "<libavdevice/avdevice.h>"
                ,
                "<libswresample/swresample.h>"
                ,
                "<libpostproc/postprocess.h>",
                //"\"cc_src/cars.h\""
                "\""+buildDir.toAbsolutePath().toFile().getAbsolutePath()+"/cars.h\""
        };

        return Arrays.asList(headers);
    }

}