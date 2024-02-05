import { ButtonProps, TypographyProps } from "@mui/material";
import { ReactNode } from "react";

export interface SocialLoginProps {
    text: string;
    src: string;
  }
  
export interface TypographyWithTextFieldProps {
  label: string;
  color: string;
  placeholder: string;
  text: string;
  src: string;
}
export interface ButtonPropsInterface extends ButtonProps { }

export interface IconComponentProps {
  width?: string;
  height?: string;
  padding?: string;
  src: string;
  sx?:React.CSSProperties,
}

export interface ImageComponentProps {
  src: string;
  height?: string;
  width?: string;
}

export interface TextFieldProps {
  placeholder?: string;
  value: string;
  onChange: (value: string) => void;
  isPassword: boolean;
  width?: string;
  height?: string | number;
  size?: "small" | "medium";
  borderRadius?: string | number;
  variant:any
}

export interface CustomTypographyProps extends TypographyProps {
  text: ReactNode;
}