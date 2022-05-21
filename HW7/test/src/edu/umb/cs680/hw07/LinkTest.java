package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class LinkTest {
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
	static void setUpBeforeClass() throws Exception {
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
	
	private String[] linkToStringArray(Link l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getName(), String.valueOf(l.getSize()),
				String.valueOf(l.getCreationTime()), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void verifyLinkEqualsM() {
		String[] expected = { "true", "m", "0", String.valueOf(m.getCreationTime()), "home", "bin" };
		Link actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	
	@Test
	public void verifyLinkEqualsN() {
		String[] expected = { "true", "n", "0", String.valueOf(n.getCreationTime()), "pictures", "y" };
		Link actual = n;
		assertArrayEquals(expected, linkToStringArray(actual));
	}

	@Test
	public void checkMisDirectoy() {
		assertFalse(m.isDirectory());
	}
	
	@Test
	public void checkMisFile() {
		assertFalse(m.isFile());
	}
	
	@Test
	public void checkMisLink() {
		assertTrue(m.isLink());
	}
	
	@Test
	public void checkMTargetTest() {
		assertSame(bin, m.getTarget());
	}
	
	@Test //remove
	public void setTargetTestingWithM() {
		m.setTarget(apps);
		assertSame(apps, m.getTarget());
	}

}
