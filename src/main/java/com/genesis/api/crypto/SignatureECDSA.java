package com.genesis.api.crypto;

import org.web3j.crypto.Sign;

public class SignatureECDSA implements Signature{

    private Sign.SignatureData rawSig;
    public SignatureECDSA(Sign.SignatureData sig) {
        this.rawSig = sig;
    }

    public SignatureECDSA( byte v, byte[] r, byte[] s){
        this.rawSig = new Sign.SignatureData(v, r, s);
    }

    public Sign.SignatureData getRawSig(){
        return this.rawSig;
    }

    @Override
    public byte[] toBytes() {
        byte[] sig = new byte[64];
        System.arraycopy(this.getR(), 0, sig, 0, 32);
        System.arraycopy(this.getS(), 0, sig, 32,  31);
        System.arraycopy(this.getV(), 0, sig, 63,  1);
        return sig;
    }

    public byte[] getR() {
        return this.rawSig.getR();
    }

    public byte[] getS() {
        return this.rawSig.getS();
    }

    public byte[] getV() {
        return new byte[]{this.rawSig.getV()};
    }
}
