package homework.hw1.methods;

import java.util.*;

public class Methods {
  
  public void swap(String[] arr, int index1, int index2) {
    String temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
  
  // �� ���� ������ IDE ���������� ����� void T ��������� )
  public <T> void swap(List<T> arr, int index1, int index2 ) {
    T temp = arr.get(index1);
    arr.set(index1, arr.get(index2));
    arr.set(index2, temp);
  }
  
  // ����� ���� ������� � �������� ��������� ������ ����������,
  // �� ����� �������� �� ����� ������� ��������� �������� �.
  // � ��������� ���������� ������ Arrays.asList, ��� ���������� ������
  // ������������� � ������������������ ���������� (T ...arr). �� �����, ������ 
  // � ������ � (T ...arr) ����� �������� ������ ����������, � � ��� ������ ���).
  // �� ���� � �������, ��� ������ ��������� ������ ������, �� ��� ������� � ���������, ��
  // ������ ��� �������� � Arrays.asList ?
  public <T> ArrayList<T> makeArrayList(T[] arr) {
    ArrayList<T> arrList = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      arrList.add(arr[i]);
    }
    return arrList;
  }
  
}
