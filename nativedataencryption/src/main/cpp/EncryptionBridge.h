//
// Created by Roman on 15.11.2024.
//

#ifndef RICKANDMORTY_ENCRYPTIONBRIDGE_H
#define RICKANDMORTY_ENCRYPTIONBRIDGE_H


#include <jni.h>
#include "DataEncryption.h"

DataEncryption encryption;

extern "C" {

// JNI method to generate a unique key
JNIEXPORT jstring JNICALL
Java_com_example_secureapp_EncryptionBridge_generateKey(JNIEnv* env, jobject obj, jstring uniqueProperties) {
    const char* cUniqueProperties = env->GetStringUTFChars(uniqueProperties, nullptr);

    std::string key = encryption.generateKey(cUniqueProperties);

    env->ReleaseStringUTFChars(uniqueProperties, cUniqueProperties);

    return env->NewStringUTF(key.c_str());
}
}


#endif //RICKANDMORTY_ENCRYPTIONBRIDGE_H
