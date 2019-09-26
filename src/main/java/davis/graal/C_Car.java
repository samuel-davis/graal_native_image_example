package davis.graal;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.word.PointerBase;

/**
 * This software was created for rights to this software belong to appropriate licenses and
 * restrictions apply. This struct describes the properties of a single codec described by an *
 * CarType.
 *
 * @author Samuel Davis created on 9/9/19.
 */
@CStruct(value = "car_t", isIncomplete = true)
@CContext(Directives.class)
public interface C_Car extends PointerBase {

    @CField("type")
    int getCarType();

    @CField("type")
    void setCarType(int type);

    @CField("id")
        //uint64_t = long
    long getId();

    @CField("id")
    void setId(long id);
}
