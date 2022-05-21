package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;

public class FileTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File x;
	private static File y;
	private static File a;
	private static File b;
	private static File c;
	

	@BeforeAll
	static void setUp() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		x = new File(apps, "x", 100, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		a = new File(pictures, "a", 30, LocalDateTime.now());
		b = new File(pictures, "b", 80, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		pictures.appendChild(a);
		pictures.appendChild(b);
	}
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void InstanceFilesEqualityCheckX() {
		String[] expected = { "false", "x", "100", String.valueOf(x.getCreationTime()), "apps" };
		File actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void InstanceFilesEqualityCheckA() {
		String[] expected = { "false", "a", "30", String.valueOf(a.getCreationTime()), "pictures" };
		File actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void checkBisDirectoy() {
		assertFalse(b.isDirectory());
	}

}
