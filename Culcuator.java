package test.mohammed;

public class Culcuator {
CulcuatorServies servies;
public Culcuator(CulcuatorServies servies) {
this.servies=servies;
}
public int add(int i, int j)
{
return servies.add(i,j)*i;
}
}

public interface CulcuatorServies {
public int add(int i, int j);
}
