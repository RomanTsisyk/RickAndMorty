package io.github.romantsisyk.nativedataencryption

class EncryptionBridge {
    external fun generateKey(uniqueProperties: String?): String?
    external fun encrypt(plaintext: String?, key: String?): String?
    external fun decrypt(ciphertext: String?, key: String?): String?

    companion object {
        init {
            System.loadLibrary("encryption-lib")
        }
    }
}
