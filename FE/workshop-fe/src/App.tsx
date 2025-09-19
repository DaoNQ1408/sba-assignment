import React from "react";
import Mindmap from "react-mindmap"

const data = {
  topic: "Main Idea",
  children: [
    { topic: "Branch 1", children: [{ topic: "Leaf 1" }, { topic: "Leaf 2" }] },
    { topic: "Branch 2" },
  ],
};

export default function App() {
  return <Mindmap data={data} />;
}
