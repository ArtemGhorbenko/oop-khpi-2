#include "ua_khpi_oop_lab16_main_NativeMeanCalculator.h"
#include <jni.h>

JNIEXPORT jdouble JNICALL Java_ua_khpi_oop_lab16_main_NativeMeanCalculator_calculateMean
  (JNIEnv *env, jobject obj, jintArray array) {

    if (array == nullptr) {
        return 0.0;
    }

    jsize len = env->GetArrayLength(array);
    if (len == 0) {
        return 0.0;
    }

    jint *elements = env->GetIntArrayElements(array, nullptr);

    long long sum = 0;
    for (int i = 0; i < len; i++) {
        sum += elements[i];
    }

    env->ReleaseIntArrayElements(array, elements, JNI_ABORT);

    return (double) sum / len;
}
