package com.playsho.android.utils

import android.util.Base64
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

object Crypto {

    private const val KEY_SIZE:Int = 2048
    private const val RSA_KEY_ALGORITHM:String = "RSA"
    fun generateRSAKeyPair(): KeyPair {
        val keyGen = KeyPairGenerator.getInstance(RSA_KEY_ALGORITHM)
        keyGen.initialize(KEY_SIZE) // You can adjust key size as needed
        return keyGen.generateKeyPair()
    }

    fun publicKeyToString(publicKey: PublicKey): String {
        val publicKeyBytes = publicKey.encoded
        return Base64.encodeToString(publicKeyBytes,Base64.DEFAULT)
    }

    fun privateKeyToString(privateKey: PrivateKey): String {
        val privateKeyBytes = privateKey.encoded
        return Base64.encodeToString(privateKeyBytes,Base64.DEFAULT)
    }

    fun stringToPublicKey(publicKeyStr: String): PublicKey {
        val publicKeyBytes = Base64.decode(publicKeyStr,Base64.DEFAULT)
        val keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM)
        val publicKeySpec = X509EncodedKeySpec(publicKeyBytes)
        return keyFactory.generatePublic(publicKeySpec)
    }

    fun stringToPrivateKey(privateKeyStr: String): PrivateKey {
        val privateKeyBytes = Base64.decode(privateKeyStr,Base64.DEFAULT)
        val keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM)
        val privateKeySpec = PKCS8EncodedKeySpec(privateKeyBytes)
        return keyFactory.generatePrivate(privateKeySpec)
    }
}