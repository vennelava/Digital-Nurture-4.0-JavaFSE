import React from "react";
import { blogs } from "./data";

function BlogDetails() {
  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <strong>{blog.author}</strong>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
