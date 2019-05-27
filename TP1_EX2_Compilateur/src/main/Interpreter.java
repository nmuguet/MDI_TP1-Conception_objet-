package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import tp6.analysis.Analysis;
import tp6.node.AAssignment;
import tp6.node.ABinexpression;
import tp6.node.ABlock;
import tp6.node.AConditional;
import tp6.node.ADiviserOperatorarith;
import tp6.node.AEqualOperatorlogique;
import tp6.node.AInfOperatorlogique;
import tp6.node.AIntegervalue;
import tp6.node.AMinusOperatorarith;
import tp6.node.AModuloOperatorarith;
import tp6.node.AMultiplierOperatorarith;
import tp6.node.APlusOperatorarith;
import tp6.node.APrintS;
import tp6.node.AReadS;
import tp6.node.ASupOperatorlogique;
import tp6.node.AVariableref;
import tp6.node.AWhileS;
import tp6.node.PStatement;


public class Interpreter extends AbstractInterpreter implements Analysis {

	int nb_indent = 0;
	
	void println(String s){
		String indent ="";
		for (int i=0;i<nb_indent;i++) {
			indent += "\t";
		}
		System.out.println(indent + s);
	}
	void print(String s) {
		String indent ="";
		for (int i=0;i<nb_indent;i++) {
			indent += "\t";
		}
		System.out.print(indent + s);
	}
	
	@Override
	public void caseAAssignment(AAssignment node) {
		print("");
		node.getVar().apply(this);
		System.out.print(node.getAssign());
		node.getRhs().apply(this);
		System.out.println(node.getSemi().getText());
	}



	@Override
	public void caseABinexpression(ABinexpression node) {
		node.getLExp().apply(this);
		System.out.print(node.getOperator());
		node.getRExp().apply(this);
		
	}


	@Override
	public void caseABlock(ABlock node) {
		System.out.println("{");
		nb_indent ++;
		for(PStatement s : node.getStatement()) {
			s.apply(this);
		}
		nb_indent --;
		System.out.println("}");

	}


	

	@Override
	public void caseAConditional(AConditional node) {
		System.out.print(node.getIf().getText()+node.getLPar());
		node.getCond().apply(this);
		System.out.println(node.getRPar()  );
		
		node.getThenpart().apply(this);
		System.out.println(node.getElse());
		node.getElsepart().apply(this);
		
	}


	@Override
	public void caseAEqualOperatorlogique(AEqualOperatorlogique node) {
	
	
	}



	@Override
	public void caseAInfOperatorlogique(AInfOperatorlogique node) {

	
	}

	@Override
	public void caseAIntegervalue(AIntegervalue node) {
		System.out.print(node.getNumber().getText());
	
	}



	@Override
	public void caseAMinusOperatorarith(AMinusOperatorarith node) {
	
	
	}

	@Override
	public void caseAMultiplierOperatorarith(AMultiplierOperatorarith node) {
		
	}



	@Override
	public void caseAPlusOperatorarith(APlusOperatorarith node) {

		
	}

	@Override
	public void caseAPrintS(APrintS node) {

		
	}


	@Override
	public void caseAReadS(AReadS node) {

	
	}



	@Override
	public void caseASupOperatorlogique(ASupOperatorlogique node) {

	
	}

	

	@Override
	public void caseAVariableref(AVariableref node) {
		System.out.print(node.getIdentifier());
	
	}


	@Override
	public void caseAWhileS(AWhileS node) {

	
	}


	@Override
	public void caseADiviserOperatorarith(ADiviserOperatorarith node) {

	
	}

	@Override
	public void caseAModuloOperatorarith(AModuloOperatorarith node) {

	
	}



}
