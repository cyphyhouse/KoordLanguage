Parser
======

The parser uses Antlr.  Maven should look at the
` grammar file <../src/main/antlr4/Koord.g4>`_ and generate the parser
to `target/generate-sources`.

The parser then creates ``KoordParser.<GrammarNode>Context`` classes,
which are used along with the ``KoordBaseListener`` class
and the tree walker class to traverse the AST.
