
#include <jni.h>


#ifndef _Included_ua_khpi_oop_lab16_main_NativeMeanCalculator
#define _Included_ua_khpi_oop_lab16_main_NativeMeanCalculator
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jdouble JNICALL Java_ua_khpi_oop_lab16_main_NativeMeanCalculator_calculateMean
  (JNIEnv *, jobject, jintArray);

#ifdef __cplusplus
}
#endif
#endif
