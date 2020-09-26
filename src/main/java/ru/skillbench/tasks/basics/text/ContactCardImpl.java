package ru.skillbench.tasks.basics.text;

import java.time.Period;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactCardImpl implements ContactCard {
    private String FN;
    private String ORG;
    private String GENDER;
    private String BDAY;
    private String[] TEL;
    private String BEGIN;
    private String END;

    public ContactCardImpl(String FN, String ORG, String GENDER, String BDAY, String[] TEL) {
        this.FN = FN;
        this.ORG = ORG;
        this.GENDER = GENDER;
        this.BDAY = BDAY;
        TEL = new String[5];
        for (int i = 0; i < TEL.length; i++) {
            TEL[i]="";
        }
    }

    public ContactCardImpl() {
        TEL = new String[5];
        for (int i = 0; i < TEL.length; i++) {
            TEL[i]="";
        }

    }

    //@Override
    public static ContactCardImpl getInstance() {
        //String parseStr = scanner.nextLine();
        String parseStr = "FN: Forrest Gump\\r\\nORG:Bubba Gump Shrimp Co.\\r\\nGENDER:M\\r\\nTEL;TYPE=HOME:4951234567\\r\\nBEGIN: kek\\r\\nEND: kek1";
        ContactCardImpl contactCard = new ContactCardImpl();
        //String str[]=parseStr.split("\r\n"); <---not working
        String result = parseStr.replace("\\r\\n", "&");
        String str[] = result.split("&");
        byte countFN = 0;
        byte countORG = 0;
        byte countBEGIN = 0;
        byte countEND = 0;
        int countAddTel = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].indexOf(':') == -1) {
                throw new InputMismatchException();
            } else {
                if (str[i].startsWith("FN")) {
                    contactCard.FN = str[i];
                    countFN++;
                }
                if (str[i].startsWith("ORG")) {
                    contactCard.ORG = str[i];
                    countORG++;
                }
                if (str[i].startsWith("BEGIN")) {
                    contactCard.BEGIN = str[i];
                    countBEGIN++;
                }
                if (str[i].startsWith("END")) {
                    contactCard.END = str[i];
                    countEND++;
                }
                if (str[i].startsWith("BDAY")) {
                    contactCard.BDAY = str[i];
                }
                if(str[i].startsWith("GENDER")){
                    contactCard.GENDER=str[i];
                }
                if (str[i].startsWith("TEL")) {
                    char[] strTOchar = str[i].toCharArray();
                    if (strTOchar[3] != ';') {
                        throw new InputMismatchException();
                    } else {
                        String[] tempStr = str[i].split(":");
                        char[] phoneNumbers = tempStr[1].toCharArray();
                        if (phoneNumbers.length < 0 || phoneNumbers.length > 10) {
                            throw new InputMismatchException();
                        } else {
                            contactCard.TEL[countAddTel] = str[i];
                            countAddTel++;
                        }
                    }
                }
            }
        }
        //Условие обязательых полей
        if (countBEGIN == 0 && countEND == 0 && countFN == 0 && countORG == 0) {
            throw new NoSuchElementException();
        }
        return contactCard;
    }


    public static void main(String[] args) {
        // Scanner scanner=new Scanner(System.in);
        ContactCardImpl contactCard = getInstance();

    }
}
