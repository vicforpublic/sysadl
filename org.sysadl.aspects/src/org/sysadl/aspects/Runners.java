package org.sysadl.aspects;

import java.util.Map;

import sysADL_Sintax.BlockStatement;
import sysADL_Sintax.DoStatement;
import sysADL_Sintax.Expression;
import sysADL_Sintax.ForStatement;
import sysADL_Sintax.IfBlockStatement;
import sysADL_Sintax.IfStatement;
import sysADL_Sintax.Statement;
import sysADL_Sintax.SwitchClause;
import sysADL_Sintax.SwitchStatement;
import sysADL_Sintax.VariableDecl;
import sysADL_Sintax.WhileStatement;

public class Runners extends SysADLStatementInterpreter{

	@Override
	public void run(Expression s, Map<String, Object> context) {
		// TODO Auto-generated method stub
		SysADLExecutionEngine a = SysADLExecutionEngine.getInstance();
		
		
	}

	@Override
	public void run(BlockStatement s, Map<String, Object> context) {
		for (Object o : s.getBody()) {
			Statement a = (Statement) o;
			run(a, context);
		}
		
	}

	@Override
	public void run(VariableDecl s, Map<String, Object> context) {
		context.put(s.getName(), s.getValue());
		
	}

	@Override
	public void run(WhileStatement s, Map<String, Object> context) {
		while(Boolean.valueOf(s.getCondition().getValue())) {
			run(s.getBody(), context);
		}
		
	}

	@Override
	public void run(DoStatement s, Map<String, Object> context) {
		do {
			run(s.getBody(), context);
		}while(Boolean.valueOf(s.getCondition().getValue()));
		
	}

	@Override
	public void run(ForStatement s, Map<String, Object> context) {
		// TODO Auto-generated method stub
		VariableDecl va = (VariableDecl) s.getControl().getVars().get(0);
		run(va,context);
		while(true) {
			run(s.getBody(), context);
			if( ! Boolean.valueOf(((Expression) s.getControl().getVars().get(1)).getValue()) ) {
				break;
			}
			Expression st = ((Expression) s.getControl().getVars().get(2));
			run(st, context);
		}
		
	}

	@Override
	public void run(IfBlockStatement s, Map<String, Object> context) {
		boolean flag = false;
		if(Boolean.valueOf(s.getMain_if().getCondition().getValue())) {
			run(s.getMain_if().getBody(),context);
			flag = true;
		}
		for(Object a : s.getSequential_ifs()) {
			IfStatement b = (IfStatement) a;
			if(Boolean.valueOf(b.getCondition().getValue())) {
				run(b.getBody(), context);
				flag = true;
			}
		}
		if(flag) {
			run(s.getElse().getBody(), context);
				
		}
	}

	@Override
	public void run(SwitchStatement s, Map<String, Object> context) {
		// TODO Auto-generated method stub
		String a = s.getExpr().getValue();
		
		for (Object o : s.getClauses()) {
			SwitchClause clause = (SwitchClause) o;
			if(a.equals(clause.getValue().getValue())) {	
				run(clause.getBody(), context);
				break;
			}
		}
	}

}
