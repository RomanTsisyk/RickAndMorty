//
// Created by Roman on 15.11.2024.
//

#include "DataEncryption.h"
#include <openssl/sha.h>
#include <sstream>
#include <iomanip>

DataEncryption::DataEncryption() {}
DataEncryption::~DataEncryption() {}

std::string DataEncryption::generateKey(const std::string& uniqueProperties) {
    unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256(reinterpret_cast<const unsigned char*>(uniqueProperties.c_str()), uniqueProperties.size(), hash);

    // Convert the hash to a hexadecimal string
    std::ostringstream hexStream;
    for (int i = 0; i < SHA256_DIGEST_LENGTH; ++i) {
        hexStream << std::hex << std::setw(2) << std::setfill('0') << static_cast<int>(hash[i]);
    }
    return hexStream.str();
}

