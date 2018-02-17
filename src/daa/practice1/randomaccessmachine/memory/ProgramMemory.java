/** File ProgramMemory. */
package daa.practice1.randomaccessmachine.memory;

/** Import the necessary classes for FileReader and BufferedReader.*/
import java.io.*;
import java.util.*;

import daa.practice1.randomaccessmachine.memory.register.ProgramRegister;


/**
 * The class ProgramMemory contains the Hash of lines-instruction that
 * represents the program the machine is running.
 * @author Ángel Igareta
 * @version 1.0
 * @since 12-2-2018
 */
public class ProgramMemory extends InfiniteMemory<ProgramRegister> {
	
	private Hashtable<String, Integer> tagHash;

	/**
	 * Constructor of the Program Memory. It reads all the lines in the program file and
	 * charges them in the Hash Table of ProgramRegister. Besides, it inserts the tags
	 * in the tagHash.
	 * @param programFilename String that contains the name of the program file.
	 * @throws IOException
	 */
	public ProgramMemory(String programFilename) throws Exception {
		super();
		
		BufferedReader reader = new BufferedReader(new FileReader(programFilename));
		tagHash = new Hashtable<String, Integer>();
		int i = 1;
		
		while (reader.ready()) {
			String newLine = reader.readLine().trim();
			
			if (!newLine.startsWith("#") && !newLine.isEmpty()) { // Omit comments or blank lines
				
				String possibleTag = newLine.split("[\t ]+")[0];
				if (possibleTag.endsWith(":")) { // Check for tags
					tagHash.put(possibleTag.replace(":", ""), i);
					newLine = newLine.replaceFirst(possibleTag, "").trim();
				}
				try {
					setRegisterAt(i, new ProgramRegister(newLine));					
				}
				catch (Exception e) {
					throw new Exception("In line " + i + ": " + e.getMessage());
				}
			}			
			i++;
		}
		
		reader.close();
	}
	
	/**
	 * @param tagName Name of the tag.
	 * @return Line of the tag passed by argument.
	 */
	public int getLineOfTag(String tagName) throws Exception {
		if (!tagHash.containsKey(tagName)) {
			throw new Exception("Tag " + tagName + " doesn't exist.");
		}
		return tagHash.get(tagName);
	}

	/* (non-Javadoc)
	 * @see daa.practice1.randomaccessmachine.memory.InfiniteMemory#setRegisterAt(int, java.lang.Object)
	 */
	@Override
	public void setRegisterAt(int index, ProgramRegister data) {
		memory.put(getPosition(index), data);
	}

	/* (non-Javadoc)
	 * @see daa.practice1.randomaccessmachine.memory.InfiniteMemory#getRegisterAt(int)
	 */
	@Override
	public ProgramRegister getRegisterAt(int index) {
		return memory.get(getPosition(index));
	}
	
	public Integer getFirstRegister() {
		return memory.firstKey();
	}
	
	public Integer getLastRegister() {
		return memory.lastKey();
	}
	
	public Integer getNextRegister(int index) {
		return memory.higherKey(index);
	}
	
	
	
}
