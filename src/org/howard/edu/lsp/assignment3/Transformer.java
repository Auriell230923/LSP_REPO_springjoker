package org.howard.edu.lsp.assignment3;

public interface Transformer<I, O> {
  O transform(I input);
}