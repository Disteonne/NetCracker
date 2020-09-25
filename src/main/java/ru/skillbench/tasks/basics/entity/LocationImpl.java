package ru.skillbench.tasks.basics.entity;


public class LocationImpl implements Location {
    private String nameLoc;
    private Type typeLoc;
    private Location parentLoc;

    public LocationImpl() {
        super();
    }

    @Override
    public String getName() {
        return nameLoc;
    }

    @Override
    public void setName(String name) {
        this.nameLoc = name;

    }

    @Override
    public Type getType() {
        return typeLoc;
    }

    @Override
    public void setType(Type type) {
        this.typeLoc = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parentLoc = parent;
    }

    @Override
    public String toString() {
        return nameLoc + " " + "(" + typeLoc + ")";
    }

    @Override
    public String getParentName() {
        if (parentLoc != null) {
            return parentLoc.getName();
        } else
            return "--";
    }

    @Override
    public Location getTopLocation() {
        if (parentLoc == null) {
            return this;
        } else
            return parentLoc.getTopLocation();
    }

    @Override
    public boolean isCorrect() {

        if (typeLoc.ordinal() > parentLoc.getType().ordinal()) {
            return true;
        } else
            return false;

        /*          ПОПЫТКА ПРОВЕРКИ ПОЛНОСТЬЮ ОТ "А" ДО "Я"
        boolean flag = false;
        boolean one = false;
        if(parentLoc.getType()!=null)
            flag=true;
        if (flag == true) {
                    if (typeLoc == Type.APARTMENT) {
                        if ((parentLoc.getType() == Type.BUILDING) || (parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.DISTRICT)
                                || (parentLoc.getType() == Type.STREET) || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY))
                            flag=true;
                    }
                    if (typeLoc == Type.BUILDING) {
                        if ((parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.DISTRICT)
                                || (parentLoc.getType() == Type.STREET) || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY))
                           flag=true;
                    }
                    if (typeLoc == Type.STREET) {
                        if ((parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.DISTRICT)
                                || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY))
                           flag=true;
                    }
                    if (typeLoc== Type.DISTRICT) {
                        if ((parentLoc.getType() == Type.CITY)
                                || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY)) {
                            flag =true;
                        }
                    }
                    if (typeLoc  == Type.REGION) {
                        if ((parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.COUNTRY)) {
                            flag=true;
                        }
                    }
                    if (typeLoc == Type.CITY) {
                        if ((parentLoc.getType() == Type.COUNTRY)) {
                            flag=true;
                        }
                    }
                    parentLoc.isCorrect();
                }
            else
            }


            while (parentLoc != null) {
                if (parentLoc.getType() == Type.APARTMENT) {
                    if ((parentLoc.getType() == Type.BUILDING) || (parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.DISTRICT)
                            || (parentLoc.getType() == Type.STREET) || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY))
                        return true;
                    else return false;
                }
                if (parentLoc.getType() == Type.BUILDING) {
                    if ((parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.DISTRICT)
                            || (parentLoc.getType() == Type.STREET) || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY))
                        return true;
                    else
                        return false;
                }
                if (parentLoc.getType() == Type.STREET) {
                    if ((parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.DISTRICT)
                            || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY)) {
                        return true;
                    } else return false;
                }
                if (parentLoc.getType() == Type.DISTRICT) {
                    if ((parentLoc.getType() == Type.CITY)
                            || (parentLoc.getType() == Type.REGION) || (parentLoc.getType() == Type.COUNTRY)) {
                        return true;
                    } else return false;
                }
                if (parentLoc.getType() == Type.REGION) {
                    if ((parentLoc.getType() == Type.CITY) || (parentLoc.getType() == Type.COUNTRY)) {
                        return true;
                    } else return false;
                }
                if (parentLoc.getType() == Type.CITY) {
                    if ((parentLoc.getType() == Type.COUNTRY)) {
                        return true;
                    } else return false;

                }
                parentLoc.isCorrect();
            }


         */

    }

    @Override
    public String getAddress() {
        String result = nameLoc + " ";

        if (parentLoc == null) {
            return result;
        } else {
            int indexPoint = 0;
            int indexEmpty = 0;
            char[] array = nameLoc.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '.') {
                    indexPoint = i;
                }
                if (array[i] == ' ') {
                    indexEmpty = i;
                }
            }
            if (array[array.length - 1] == '.' || indexPoint == indexEmpty - 1) {
                result += parentLoc.getName() + " ";
            } else {
                result += getType().getNameForAddress() + " " + parentLoc.getName();
            }
        //getTopLocation();
        }
        return result+=getTopLocation().getAddress();
    }

    public static void main(String[] args) {
        LocationImpl l1 = new LocationImpl();
        l1.nameLoc = "Moscow street.";
        l1.typeLoc = Type.CITY;
        LocationImpl l2 = new LocationImpl();
        l2.nameLoc = "Russia";
        l2.typeLoc = Type.COUNTRY;
        l1.parentLoc = l2;

        System.out.println(l1.isCorrect());
        System.out.println(l1.getAddress());

        LocationImpl l3 = new LocationImpl();
        l3.typeLoc = Type.BUILDING;
        l3.nameLoc = "10 к.1";
        LocationImpl l4 = new LocationImpl();
        l4.typeLoc = Type.STREET;
        l4.nameLoc = "ул. Академика";
        LocationImpl l5 = new LocationImpl();
        l5.typeLoc = Type.CITY;
        l5.nameLoc = " г. Долгопрудный";
        LocationImpl l6 = new LocationImpl();
        l6.typeLoc = Type.REGION;
        l6.nameLoc = "Московская обл.";
        LocationImpl l7 = new LocationImpl();
        l7.nameLoc = "Russia";
        l7.typeLoc = Type.COUNTRY;
        l3.parentLoc=l4;
        l4.parentLoc=l5;
        l5.parentLoc=l6;
        String str=l3.getAddress();
       // System.out.println(l3.getAddress());
    }
}
