package homework.hw1.methods;

import java.util.*;

public class Methods {
  
  public <T> void swap(T[] arr, int index1, int index2) {
    T temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
   
/*
 � ������ Arrays.asList ��� �������� � ���� �������, ������ ������������� � ������������������
 ���������� (� ...arr) � ���������� ����� ��� ������ ���������� ��� � ������ ������.
 � ��� ����� �������� �������� ������ ������ ������, � ��������� ������ �� ��������).
 ����� ������� ���������� ������� ������ ����������, �� ����� ����� ����� ���� ������� ���
 ������������� �������� - ���� ������-������� ��� ����� ���������.
 � �� ����� - ������ � Arrays.asList ����� ���������� ������ ����� ����� ? ) 
 */
  public <T> ArrayList<T> makeArrayList(T[] arr) {
    ArrayList<T> arrList = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      arrList.add(arr[i]);
    }
    return arrList;
  }
  
}
