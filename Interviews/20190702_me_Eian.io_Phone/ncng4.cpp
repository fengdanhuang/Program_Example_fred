// ProductIndex.h
//

#pragma once

// given a collection of N records, for which each attribute flag can be assumed
// to default to false unless specified true, we want to (a) initialize some
// kind of index, possibly with support for load/store persistence, with no
// explicit limit on efficiency for initialization, and (b) execute a high
// volume of calls to find_all_where(...) with extremely high performance
//
// N may be extremely large. For the sake of argument, let's say N is on the
// order of 100 million to 1 billion records.

// 25% of attributes are a very sparse attribute: < 1% of records are set to true;
// 25% of attributes are a very dense attribute: > 99% of records are set to true;
// 50% of attributes are an average attribute: between 1% and 99% - most are between 30% and 70%


java.util.BitSet


class AttributeFilteredLookup {
  
public:
  explicit AttributeFilteredLookup(size_t initial_reserved_size);
  bool set_attribute(size_t record_index);
  bool clear_attribute(size_t record_index);
  bool flip_attribute(size_t record_index);
  bool is_set(size_t record_index) const;
  // the return type need not be a std::vector, but it should support iterating
  // across the reulting set of record_index results in a consistent order.
  std::vector<size_t> find_all_where(bool query) const;
};

  Col 
0 F
1 F
2 F


N 

index x -> formula(X) -> y


...
initialize(){

}

List<S> find_all_where(boolean query){


}






