

	import java.util.ArrayList;

	import pmatch.MStringVector;
	import sheffield.EasyWriter;

	public class WarriorStrips {
		 public static void main(String[] args) {
			    EasyWriter scr=new EasyWriter();

			    //create the operators
			    //operator responsible for moving warrior from one place to another
			    StripsOp move = new StripsOp("warrior moves from ?W to ?place", 
			    								"warrior in ?place",
			    								"warrior in ?W",
												"warrior in ?W");
			    //operator responsible for attaching hook to rope
			    StripsOp attach = new StripsOp("attach rope to hook in ?place", 
												"rope&hook in ?place",
												"hook in ?place|rope in ?place",
			    								"snake in pit|warrior in ?place|rope in ?place|hook in ?place");		    
			    
			    //operator responsible for carrying things by warrior
			    StripsOp carry = new StripsOp("warrior carry ?o from ?place1 to ?place2", 
												"warrior in ?place2|?o in ?place2",
												"?o in ?place1|warrior in ?place1",
												"?o in ?place1|warrior in ?place1");
			    //operator responsible for put things into pit
			    StripsOp putIntoPit = new StripsOp("warrior put ?obj into pit from edge", 
													"?obj in pit",
													"?obj in edge",
													"warrior in edge|?obj in edge");
			    //operator responsible for pulling chest from pit by using hook and rope
			    StripsOp pullChest = new StripsOp("pull chest from pit", 
													"chest in edge",
													"chest in pit",
												"snake in pit|rope&hook in pit|warrior in edge|chest in pit");
			    //operator responsible for getting chest by using the ladder
			    StripsOp getChest = new StripsOp("warrior goes using ladder to pit and get chest", 
													"chest in edge",
													"chest in pit",
													"ladder in pit|snake not in pit|ladder in pit|warrior in edge|chest in pit"); 				
			    
			    //form them into a vector
			    
			    ArrayList<StripsOp> warriorOps = new ArrayList<StripsOp>();
			    
			    warriorOps.add(getChest);
			    warriorOps.add(pullChest);
			    warriorOps.add(move);
			    warriorOps.add(putIntoPit);				    
			    warriorOps.add(attach);				  			    
			    warriorOps.add(carry);	   
			    
			    
			   
			    //create instance of Strips1, give it the operators, init state & goal state

			    Strips1 str=new Strips1(warriorOps,
			                            new MStringVector("warrior in W|snake not in pit|ladder in L|rope in R|hook in H|chest in pit"),
			                            new MStringVector("chest in edge"));


			    //run Strips
			    boolean res=str.run();
			    scr.println("Result is "+res); //result
			    scr.println("Plan is   "+str.getPlan()); //plan

			  }
	}

