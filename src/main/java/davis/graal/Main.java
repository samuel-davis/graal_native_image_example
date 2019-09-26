package davis.graal;


import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.nativeimage.Platform.LINUX_AMD64;
import org.graalvm.nativeimage.Platforms;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CFunction;
import org.graalvm.nativeimage.c.function.CFunction.Transition;
import org.graalvm.nativeimage.c.function.CLibrary;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.type.CTypeConversion.CCharPointerHolder;
import org.graalvm.polyglot.Context;

/**
 * This software was created for rights to this software belong to appropriate licenses and
 * restrictions apply.
 *
 * @author Samuel Davis created on 9/5/19.
 */
@Slf4j
@Platforms(value = LINUX_AMD64.class)
@CContext(Directives.class)
@CLibrary("cars")
public class Main {

    //private static ObjectMapper mapper = new ObjectMapper();

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native C_Garage createGarage();

    @CFunction(transition = Transition.NO_TRANSITION)
    public static native void freeGarage(C_Garage garage);


    @CFunction(transition = Transition.NO_TRANSITION)
    public static native void sayHello();

    private static void testAllocationAndRemoval() {
        long iterations = 100_000_000L;
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 0; i < iterations; i++) {
            C_Garage garage = createGarage();
            sum += garage.firstCar().getId() + garage.secondCar().getId() + garage.thirdCar()
                    .getId();
            freeGarage(garage);
        }
        long end = System.currentTimeMillis();
        double timeTaken = ((double) (end - start) * 1_000_000L) / iterations;
        log.info("Final sum is: " + sum + ", time taken per iteration in nano seconds: "
                + timeTaken);
    }


    public static void wowLanguages(){
        System.out.println("Hello polyglot world Java!");
        Context context = Context.create();
        context.eval("js", "print('Hello polyglot world JavaScript!');");
        context.eval("ruby", "puts 'Hello polyglot world Ruby!'");
        context.eval("R", "print('Hello polyglot world R!');");
        context.eval("python", "print('Hello polyglot world Python!');");
    }

    public static void main(String[] args) throws IOException {
        sayHello();
        wowLanguages();
        //testAllocationAndRemoval();
        testGettingUpdatingSettingString();

        testGettingUpdatingSettingStringArray();


    }

    private static void testGettingUpdatingSettingStringArray() {
        C_Garage garage = createGarage();
        garage.getCarOwnerNames();
        String firstOwner = CTypeConversion.toJavaString(garage.getCarOwnerNames().read(0));
        log.info("FirstOwner = {}", firstOwner);

        //log.info(garage.getCarOwnerNames()..getClass().getCanonicalName());

        String secondOwner = CTypeConversion
                .toJavaString(garage.getCarOwnerNames().read(1));
        log.info("SecondOwner = {}", secondOwner);

        String thirdOwner = CTypeConversion
                .toJavaString(garage.getCarOwnerNames().read(2));
        log.info("ThirdOwner = {}", thirdOwner);
    }

    private static void testGettingUpdatingSettingString() {
        C_Garage garage = createGarage();
        CCharPointer ownerNamePointer = garage.getOwnerName();

        String s = CTypeConversion.toJavaString(ownerNamePointer);
        log.info("Owner Name = {}", s);
        //Getting Complete

        CCharPointerHolder kk = CTypeConversion.toCString("BoB");
        garage.setOwnerName(kk.get());
        kk.close();
        log.info("New Garage Owner Name = {}", CTypeConversion.toJavaString(garage.getOwnerName()));
        freeGarage(garage);
        //Update Complete

        C_Garage anotherGarage = createGarage();
        log.info("Initial Owner Name = {}",
                CTypeConversion.toJavaString(anotherGarage.getOwnerName()));
        anotherGarage.setOwnerName(CTypeConversion.toCString("BoB's Your Uncle").get());
        log.info("New Owner Name = {}", CTypeConversion.toJavaString(anotherGarage.getOwnerName()));
    }


}
