package com.audio;

public class SongsIdDoesnotExistException extends Exception
{
    public SongsIdDoesnotExistException(String message)
    {
        super(message);
    }

    @Override
    public String toString() {
        return "SongsIdDoesNotExistException{ \n Songs ID you Entered  By you does not exist!!! \n Please enter valid Songs ID }";
    }
}
