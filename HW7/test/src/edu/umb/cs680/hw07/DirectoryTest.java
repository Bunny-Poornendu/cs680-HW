package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class DirectoryTest {
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
	private static Link m;
	private static Link n;
	

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
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(pictures, "n", 0, LocalDateTime.now(), y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
	}

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}
	@Test
	public void verifyHomeLinks() {
		assertSame(m, home.getLinks().get(0));
	}

	@Test
	public void verifyPicturesLinks() {
		assertSame(n, pictures.getLinks().get(0));
	}
	@Test
	public void InstanceDirectoryEqualityCheckRoot() {
		String[] expected = { "true", "root", "280", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void InstanceDirectoryEqualityCheckHome() {
		String[] expected = { "true", "home", "160", String.valueOf(home.getCreationTime()), "3" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void InstanceDirectoryEqualityCheckApps() {
		String[] expected = { "true", "apps", "120", String.valueOf(apps.getCreationTime()), "2" };
		Directory actual = apps;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void InstanceDirectoryEqualityCheckBin() {
		String[] expected = { "true", "bin", "0", String.valueOf(bin.getCreationTime()), "0" };
		Directory actual = bin;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	void verifyDirectory() {
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(apps.isDirectory());
		assertTrue(pictures.isDirectory());
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(x.isDirectory());
		assertFalse(y.isDirectory());
	}
	@Test
	public void verifyFiles() {
		assertTrue(a.isFile());
		assertTrue(b.isFile());
		assertTrue(c.isFile());
		assertTrue(x.isFile());
		assertTrue(y.isFile());
	}

	
	@Test
	public void checkRootisDirectoy() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void checkRootisFile() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void checkRootisLink() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void verifyappendChildrenWithRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void verifyappendChildrenWithHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void RootChildrenCountTest() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void HomeChildrenCountTest() {
		assertSame(3, home.countChildren());
	}
	
	@Test
	public void verifyRootSubDirectories() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyHomeSubDirectories() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void verifyHomeFiles() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void verifyPicturesFiles() {
		File[] expected = new File[2];
		expected[0] = a;
		expected[1] = b;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}

	
	@Test
	public void verifyRootTotalSize() {
		assertEquals(280, root.getTotalSize());
	}
	
	@Test
	public void verifyHomeTotalSize() {
		assertEquals(160, home.getTotalSize());
	}

}
