
@NamedQueries({
        @NamedQuery(name= "all", query = "select e from Employee e" )
})
package com.example.carsrd.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;