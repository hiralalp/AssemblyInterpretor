package com.miko.assemblyinterpretor.logic;

import java.util.HashMap;

import org.springframework.stereotype.Component;


@Component
public class AssemblyInterpreter {
    private HashMap<String, Integer> registers;
    
    private int result=-1;

    public AssemblyInterpreter() {
        registers = new HashMap<>();
        
    }

    public void executeInstruc(String instruction) {
    	
    	if(result>0)
    		result=-1;
        String[] parts = instruction.split("[,\\s]+");
        
        //System.out.println(parts);
        if (parts[0].equals("MV")) {
            String register = parts[1];
            int value = Integer.parseInt(parts[2].substring(1));
            //System.out.println(value);
            registers.put(register, value);
            //System.out.println(registers);
        } else if (parts[0].equals("ADD")) {
            String register1 = parts[1];
            if (parts[2].startsWith("#")) { // If the operand is a constant
                int constant = Integer.parseInt(parts[2].substring(1));
                registers.put(register1, getRegisValue(register1) + constant);
            } else { // If the operand is another register
                String register2 = parts[2];
                registers.put(register1, getRegisValue(register1) + getRegisValue(register2));
            }
        } else if (parts[0].equals("SHOW")) {
            String register = parts[1];
            System.out.println(getRegisValue(register));
            result = getRegisValue(register);
            
        }else {
        	System.out.println("query format is not proper!!");
        	result=-1;
        }
        
        
    }

    public int getRegisValue(String register) {
    	//System.out.println(registers.get(register));
    	//System.out.println(registers);
        return registers.getOrDefault(register, 0);
    }

    public int executeProgram(String program) {
        String[] instructions = program.split("\n");
        for (String instruction : instructions) {
        	//System.out.println(instruction);
            if (!instruction.isEmpty()) {
                executeInstruc(instruction.trim());
            }
        }
        return result;
     
    }

	/*
	 * public static void main(String[] args) { AssemblyInterpreter interpreter =
	 * new AssemblyInterpreter();
	 * 
	 * // Example program String program = "MV REG1 #2000\n" + "MV REG2 #4000\n" +
	 * "ADD REG1 REG2\n" + "ADD REG1 #600\n" + "SHOW REG1";
	 * 
	 * interpreter.executeProgram(program); }
	 */
}
