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

public class Evaluator extends AbstractInterpreter implements Analysis {

	Stack<Integer> value= new Stack<Integer>();
	String varRefName;

	Map<String, Integer> dicoVar = new HashMap<String, Integer>();

	@Override
	public void caseAAssignment(AAssignment node) {
		node.getVar().apply(this);
		int v = this.value.pop();
		node.getRhs().apply(this);
		dicoVar.put(varRefName, v);
	}

	@Override
	public void caseABinexpression(ABinexpression node) {
		node.getLExp().apply(this);
		node.getRExp().apply(this);
		node.getOperator().apply(this);
		
		
	}

	@Override
	public void caseABlock(ABlock node) {
		System.out.println("{");
		for (PStatement s : node.getStatement()) {
			s.apply(this);
		}
		System.out.println("}");

	}

	@Override
	public void caseAConditional(AConditional node) {

	}

	@Override
	public void caseAEqualOperatorlogique(AEqualOperatorlogique node) {

	}

	@Override
	public void caseAInfOperatorlogique(AInfOperatorlogique node) {

	}

	@Override
	public void caseAIntegervalue(AIntegervalue node) {
		this.value.push(Integer.parseInt(node.getNumber().getText()));
	}

	@Override
	public void caseAMinusOperatorarith(AMinusOperatorarith node) {

	}

	@Override
	public void caseAMultiplierOperatorarith(AMultiplierOperatorarith node) {

	}

	@Override
	public void caseAPlusOperatorarith(APlusOperatorarith node) {
		int r = this.value.pop();
		int l = this.value.pop();
		this.value.push(l+r);
	}

	@Override
	public void caseAPrintS(APrintS node) {
		node.getValue().apply(this);
		System.out.println(this.value.pop());

	}

	@Override
	public void caseAReadS(AReadS node) {

	}

	@Override
	public void caseASupOperatorlogique(ASupOperatorlogique node) {

	}

	@Override
	public void caseAVariableref(AVariableref node) {
		this.varRefName = node.getIdentifier().getText();
		if (this.dicoVar.containsKey(this.varRefName)) {
			this.value.push(this.dicoVar.get(this.varRefName));
		}
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
