package iFly;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DatabaseMetaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import UI.MainPage;
import UI.ManagerPage;
import UI.RegistarPage;
import UI.ResultPage;
import UI.SearchPage;


@SuppressWarnings("unused")
public class Main 
{	
	public static void main(String[] args)
	{
		DataBase.init();
		MainPage.MpFun(); 
	}
}