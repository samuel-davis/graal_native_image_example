package davis.graal;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.constant.CEnum;
import org.graalvm.nativeimage.c.constant.CEnumLookup;
import org.graalvm.nativeimage.c.constant.CEnumValue;

/**
 * This software was created for rights to this software belong to appropriate licenses and
 * restrictions apply.
 *
 * @author Samuel Davis created on 9/9/19.
 */
@CEnum("car_type_t")
@CContext(Directives.class)
public enum CarType {
    FORD, CHEVY, DODGE;

//    @CEnumConstant
//    public int AV_CODEC_ID_FIRST_SUBTITLE = 0x17000;


    @CEnumLookup
    public static native CarType fromCValue(int value);

    @CEnumValue
    public native int getCValue();
}
