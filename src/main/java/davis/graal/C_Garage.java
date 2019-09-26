package davis.graal;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CFieldAddress;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CCharPointerPointer;
import org.graalvm.word.PointerBase;
import org.graalvm.word.UnsignedWord;
import org.graalvm.word.WordBase;

/**
 * This software was created for rights to this software belong to appropriate licenses and
 * restrictions apply.
 *This struct describes the properties of a single codec described by an
 *  * CarType.
 * @author Samuel Davis created on 9/9/19.
 */
@CStruct(value = "garage_t", isIncomplete = true)
@CContext(Directives.class)
public interface C_Garage extends PointerBase {

    @CFieldAddress("car1")
    C_Car firstCar();
    @CFieldAddress("car2")
    C_Car secondCar();
    @CFieldAddress("car3")
    C_Car thirdCar();


    @CField("owner_name")
    CCharPointer getOwnerName();

    @CField("owner_name")
    void setOwnerName(CCharPointer name);


    @CField("car_owner_names")
    CCharPointerPointer getCarOwnerNames();

    @CField("car_owner_names")
    void setCarOwnerNames(CCharPointerPointer names);

    //@CField("name")
    //void setName(String name);


}
