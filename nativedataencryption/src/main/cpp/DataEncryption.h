//
// Created by Roman on 15.11.2024.
//

#ifndef RICKANDMORTY_DATAENCRYPTION_H
#define RICKANDMORTY_DATAENCRYPTION_H


#include <string>

class DataEncryption {
public:
    DataEncryption();
    ~DataEncryption();

    std::string encrypt(const std::string& plaintext, const std::string& key);

    std::string decrypt(const std::string& ciphertext, const std::string& key);

    std::string generateKey(const std::string& uniqueProperties);
};

#endif // RICKANDMORTY_DATAENCRYPTION_H
